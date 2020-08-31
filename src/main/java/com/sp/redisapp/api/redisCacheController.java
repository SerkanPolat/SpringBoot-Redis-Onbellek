package com.sp.redisapp.api;

import com.sp.redisapp.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class redisCacheController {
    @Autowired
    private RedisCacheService redisCacheService;

    @GetMapping
    public String CacheControl(){
        return redisCacheService.longRunningMetod();
    }

    //Cache temizleme islemi manuel olarak yapilandirildi.Otomatik halede getirilebilir.
    @GetMapping("/temizle")
    public void CacheClear(){
        redisCacheService.ClearCache();
    }
}
