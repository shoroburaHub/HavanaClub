package com.HavanaClub.serviceImpl;

import com.HavanaClub.dao.IngredientDao;
import com.HavanaClub.entity.Ingredient;
import com.HavanaClub.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientDao ingredientDao;

    public void save(Ingredient ingredient) {

        ingredientDao.save(ingredient);
    }

    public List<Ingredient> findAll() {
        return ingredientDao.findAll();
    }

    public Ingredient findOne(int id) {
        return ingredientDao.findOne(id);
    }

    public void delete(int id) {
        ingredientDao.delete(id);
    }

    public void update(Ingredient ingredient) {
        ingredientDao.save(ingredient);
    }

    @Override
    public Page<Ingredient> findAllPages(Pageable pageable) {
        return ingredientDao.findAll(pageable);
    }
}
