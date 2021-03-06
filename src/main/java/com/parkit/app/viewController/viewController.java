package com.parkit.app.viewController;

import com.parkit.app.model.Parking;
import com.parkit.app.model.Sensor;
import com.parkit.app.service.ParkingService;
import com.parkit.app.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class viewController {

    private final ParkingService parkingService;
    private final SensorService sensorService;

    @Autowired
    public viewController(ParkingService parkingService, SensorService sensorService){

        this.parkingService = parkingService;
        this.sensorService = sensorService;
    }

    @RequestMapping(value = {"/index.hmtl","/"},method = RequestMethod.GET)
   public String viewIndex(ModelMap modelMap){

        List<Parking> parkings = parkingService.findAllParking();

        modelMap.addAttribute("parkings", parkings);

        return "index";
    }

    @RequestMapping(value = "/page1.html",method = RequestMethod.GET)
    public String viewSanMames(ModelMap modelMap){

        List<Sensor> sensors = sensorService.findSensorsByParkingId(1);

        modelMap.addAttribute("sensors", sensors);
        return "page1";
    }

    @RequestMapping(value = "/page2.html",method = RequestMethod.GET)
    public String viewMoyua(ModelMap modelMap){

        List<Sensor> sensors = sensorService.findSensorsByParkingId(2);

        modelMap.addAttribute("sensors", sensors);

        return "page2";
    }

    @RequestMapping(value = "/page3.html",method = RequestMethod.GET)
    public String viewAldeZaharra(ModelMap modelMap){

        List<Sensor> sensors = sensorService.findSensorsByParkingId(3);

        modelMap.addAttribute("sensors", sensors);

        return "page3";
    }

}
