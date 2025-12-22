package com.example.controller;

import com.example.entity.Coffee;
import com.example.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/coffees")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping
    public String listCoffees(Model model) {
        model.addAttribute("coffees", coffeeService.getAllCoffees());
        model.addAttribute("coffeeTypes", Coffee.CoffeeType.values());
        return "coffees";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("coffee", new Coffee());
        model.addAttribute("coffeeTypes", Coffee.CoffeeType.values());
        return "add-coffee";
    }

    @PostMapping("/add")
    public String addCoffee(@ModelAttribute Coffee coffee) {
        coffeeService.saveCoffee(coffee);
        return "redirect:/coffees";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Coffee coffee = coffeeService.getCoffeeById(id);
        if (coffee == null) {
            return "redirect:/coffees";
        }
        model.addAttribute("coffee", coffee);
        model.addAttribute("coffeeTypes", Coffee.CoffeeType.values());
        return "edit-coffee";
    }

    @PostMapping("/edit/{id}")
    public String editCoffee(@PathVariable Integer id, @ModelAttribute Coffee coffee) {
        coffee.setId(id);
        coffeeService.saveCoffee(coffee);
        return "redirect:/coffees";
    }

    @GetMapping("/delete/{id}")
    public String deleteCoffee(@PathVariable Integer id) {
        coffeeService.deleteCoffee(id);
        return "redirect:/coffees";
    }

    @GetMapping("/pack-van")
    public String packVan(Model model) {
        List<Coffee> allCoffees = coffeeService.getAllCoffees();

        // Рассчитываем общую статистику
        int itemCount = allCoffees.size();
        double totalWeight = allCoffees.stream()
                .mapToDouble(c -> c.getWeight() * c.getQuantity())
                .sum();
        double totalVolume = allCoffees.stream()
                .mapToDouble(c -> (c.getVolume() != null ? c.getVolume() : 0) * c.getQuantity())
                .sum();
        double totalValue = allCoffees.stream()
                .mapToDouble(c -> c.getPrice() * c.getQuantity())
                .sum();

        model.addAttribute("itemCount", itemCount);
        model.addAttribute("totalWeight", totalWeight);
        model.addAttribute("totalVolume", totalVolume);
        model.addAttribute("totalValue", totalValue);

        return "pack-van";
    }

    @PostMapping("/pack-van/optimize")
    public String optimizePackVan(
            @RequestParam(required = false) Double maxWeight,
            @RequestParam(required = false) Double maxVolume,
            Model model) {

        List<Coffee> allCoffees = coffeeService.getAllCoffees();

        // Рассчитываем общую статистику (для верхней части страницы)
        int itemCount = allCoffees.size();
        double totalWeight = allCoffees.stream()
                .mapToDouble(c -> c.getWeight() * c.getQuantity())
                .sum();
        double totalVolume = allCoffees.stream()
                .mapToDouble(c -> (c.getVolume() != null ? c.getVolume() : 0) * c.getQuantity())
                .sum();
        double totalValue = allCoffees.stream()
                .mapToDouble(c -> c.getPrice() * c.getQuantity())
                .sum();

        model.addAttribute("itemCount", itemCount);
        model.addAttribute("totalWeight", totalWeight);
        model.addAttribute("totalVolume", totalVolume);
        model.addAttribute("totalValue", totalValue);

        // Простой алгоритм оптимизации - сортировка по плотности
        List<Coffee> optimizedList = allCoffees.stream()
                .filter(c -> c.getVolume() != null && c.getVolume() > 0)
                .sorted((c1, c2) -> {
                    double density1 = c1.getWeight() / c1.getVolume();
                    double density2 = c2.getWeight() / c2.getVolume();
                    return Double.compare(density2, density1); // сортируем по убыванию плотности
                })
                .collect(Collectors.toList());

        model.addAttribute("optimizedCoffees", optimizedList);
        model.addAttribute("maxWeight", maxWeight);
        model.addAttribute("maxVolume", maxVolume);

        // Рассчитываем использование для выбранных товаров
        double loadedWeight = optimizedList.stream()
                .mapToDouble(c -> c.getWeight() * c.getQuantity())
                .sum();
        double loadedVolume = optimizedList.stream()
                .mapToDouble(c -> (c.getVolume() != null ? c.getVolume() : 0) * c.getQuantity())
                .sum();
        double loadedValue = optimizedList.stream()
                .mapToDouble(c -> c.getPrice() * c.getQuantity())
                .sum();

        model.addAttribute("loadedWeight", loadedWeight);
        model.addAttribute("loadedVolume", loadedVolume);
        model.addAttribute("loadedValue", loadedValue);

        // Рассчитываем процент использования
        double utilizationWeight = 0;
        double utilizationVolume = 0;

        if (maxWeight != null && maxWeight > 0) {
            utilizationWeight = Math.min(100, (loadedWeight / maxWeight) * 100);
        }
        if (maxVolume != null && maxVolume > 0) {
            utilizationVolume = Math.min(100, (loadedVolume / maxVolume) * 100);
        }

        model.addAttribute("utilizationWeight", utilizationWeight);
        model.addAttribute("utilizationVolume", utilizationVolume);

        return "pack-van";
    }

    @GetMapping("/find")
    public String showFindCoffee(Model model) {
        model.addAttribute("coffeeTypes", Coffee.CoffeeType.values());
        return "find-coffee";
    }

    @PostMapping("/find")
    public String findCoffee(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Coffee.CoffeeType type,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Double minWeight,
            @RequestParam(required = false) Double maxWeight,
            @RequestParam(required = false) Integer minQuantity,
            Model model) {

        List<Coffee> allCoffees = coffeeService.getAllCoffees();

        // Фильтрация по критериям
        List<Coffee> filteredCoffees = allCoffees.stream()
                .filter(coffee -> {
                    // Фильтр по имени
                    if (name != null && !name.isEmpty()) {
                        if (!coffee.getName().toLowerCase().contains(name.toLowerCase())) {
                            return false;
                        }
                    }

                    // Фильтр по типу
                    if (type != null && coffee.getType() != type) {
                        return false;
                    }

                    // Фильтр по цене
                    if (minPrice != null && coffee.getPrice() < minPrice) {
                        return false;
                    }
                    if (maxPrice != null && coffee.getPrice() > maxPrice) {
                        return false;
                    }

                    // Фильтр по весу
                    if (minWeight != null && coffee.getWeight() < minWeight) {
                        return false;
                    }
                    if (maxWeight != null && coffee.getWeight() > maxWeight) {
                        return false;
                    }

                    // Фильтр по количеству
                    if (minQuantity != null && coffee.getQuantity() < minQuantity) {
                        return false;
                    }

                    return true;
                })
                .collect(Collectors.toList());

        // Рассчитываем статистику
        double avgPrice = filteredCoffees.stream()
                .mapToDouble(Coffee::getPrice)
                .average()
                .orElse(0);

        int totalStock = filteredCoffees.stream()
                .mapToInt(Coffee::getQuantity)
                .sum();

        // Добавляем атрибуты в модель
        model.addAttribute("coffees", filteredCoffees);
        model.addAttribute("coffeeTypes", Coffee.CoffeeType.values());
        model.addAttribute("searchName", name);
        model.addAttribute("searchType", type);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("minWeight", minWeight);
        model.addAttribute("maxWeight", maxWeight);
        model.addAttribute("minQuantity", minQuantity);
        model.addAttribute("resultCount", filteredCoffees.size());
        model.addAttribute("avgPrice", avgPrice);
        model.addAttribute("totalStock", totalStock);

        return "find-coffee";
    }
}