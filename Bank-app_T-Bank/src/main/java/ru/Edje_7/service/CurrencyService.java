package ru.Edje_7.service;


import org.springframework.stereotype.Service;
import ru.Edje_7.model.Currency;
import ru.Edje_7.repository.CurrencyRepository;

import java.util.List;
import java.util.UUID;


@Service
public class CurrencyService {

    private CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public List<Currency> getCurrencies(){
        return currencyRepository.findAll();
    }

    public Currency addCurrency(Currency currency){
        for(Currency searchCurrency : getCurrencies()){
            if(searchCurrency.getId().equals(currency.getId())){
                return currency;
            }
        }
        String id = UUID.randomUUID().toString();
        currency.setId(id);
        return currencyRepository.save(currency);
    }

    public Currency getCurrencyById(String id){
        return currencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найдена валюта с ID:" + id));
    }

    public Currency updateCurrency(String id, Currency currency){
        Currency updatedCurrency = getCurrencyById(id);
        updatedCurrency.setName(currency.getName());
        updatedCurrency.setBaseCurrency(currency.getBaseCurrency());
        updatedCurrency.setPriceChangeRange(currency.getPriceChangeRange());
        updatedCurrency.setDescription(currency.getDescription());
        return currencyRepository.save(updatedCurrency);
    }

    public void deleteCurrencyById(String id){
        currencyRepository.deleteById(id);
    }


}
