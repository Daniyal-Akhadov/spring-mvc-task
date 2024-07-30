package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.CarDao;

@Controller
@RequestMapping("cars")
public class CarController {

    private final CarDao carDao;

    @Autowired
    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping()
    public String getSomeCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        System.out.println(count + " cars found");

        if (count == null)
            model.addAttribute("cars", carDao.getCars());
        else if (count < carDao.getCars().size())
            model.addAttribute("cars", carDao.getCars(count));
        else if (count >= carDao.getCars().size())
            model.addAttribute("cars", carDao.getCars());

        return "cars";
    }
}
