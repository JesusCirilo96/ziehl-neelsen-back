package com.ziehlneelsen.laboratorio.repository.menu;

import com.ziehlneelsen.laboratorio.entities.menu.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {
    Void save (Optional<MenuEntity> menu);
}
