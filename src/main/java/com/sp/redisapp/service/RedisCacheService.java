package com.sp.redisapp.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {
    /*Metod Cachelenebilir olarak isaretlendi.Ilk Calismasi normal olacak
    Cikti cache de saklanacak ve sonraki cagrimlarda metod calismayip veri cacheden gelecek.
    Sonuc Cache icin redis kullanildigi icin redise kaydedildi.

     */

    @Cacheable(cacheNames = "UzunSurenMetodCache")
    public String longRunningMetod(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Uzun Sured Metod Calisti";
    }
    //Cache belirli sureler ile temizlenmesi ve metodun tekrar calismasi gereklidir.
    //Aksi halde ilk calismadaki sonuc doner.
    @CacheEvict(cacheNames = "UzunSurenMetodCache")
    public void ClearCache(){
        System.out.println("Cache Temizlendi.");
    }

}
