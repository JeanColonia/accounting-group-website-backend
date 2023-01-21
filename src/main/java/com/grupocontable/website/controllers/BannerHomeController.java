package com.grupocontable.website.controllers;


import com.grupocontable.website.model.BannerHome;
import com.grupocontable.website.service.BannerHomeService;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("bannerhome/api")
public class BannerHomeController {

    private final BannerHomeService bannerHomeService;
    public BannerHomeController(BannerHomeService bannerHomeService){
        this.bannerHomeService = bannerHomeService;
    }


    @PostMapping("/")
    public ResponseEntity<BannerHome> crearBannerHome(@RequestBody BannerHome bannerhome){
        BannerHome bannerHome = bannerHomeService.agregarBannerHome(bannerhome);
        return ResponseEntity.ok(bannerHome);

    }

    @GetMapping("/")
    public ResponseEntity<?> listarBannerHome(){
          return ResponseEntity.ok(bannerHomeService.obtenerBannerHomeList());

    }

    @GetMapping("/{idBanner}")
    public BannerHome obtenerBannerHome(@PathVariable("idBanner") Integer idbanner){
        return bannerHomeService.obtenerBannerHome(idbanner);
    }



    @PutMapping("/")
    public BannerHome actualizarBannerHome(@RequestBody BannerHome bannerHome){
        return bannerHomeService.actualizarBannerHome(bannerHome);
    }


    @DeleteMapping("/{idBanner}")
    public void eliminarBannerHome(@PathVariable("idBanner") Integer idbanner){
       bannerHomeService.eliminarBannerHome(idbanner);
    }

}
