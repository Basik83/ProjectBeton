package pl.sdacademy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/beton")
public class BetonController {
    private final BetonRepository betonRepository;

    public BetonController(BetonRepository betonRepository) {
        this.betonRepository = betonRepository;
    }

    @GetMapping
    public String getAll(ModelMap modelMap) {
        List<Beton> betonList = betonRepository.findAll();
        modelMap.addAttribute("betony", betonList);
        return "betony";
    }

    @GetMapping("/add")
    public String getnowyBeton() {
        return "nowyBeton";
    }

    @PostMapping("/add")
    public String create(Beton beton) {
        betonRepository.save(beton);
        return "redirect:/beton";
    }




}
