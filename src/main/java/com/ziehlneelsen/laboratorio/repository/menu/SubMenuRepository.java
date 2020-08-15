package com.ziehlneelsen.laboratorio.repository.menu;

import com.ziehlneelsen.laboratorio.entities.menu.SubMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubMenuRepository extends JpaRepository<SubMenuEntity, Integer> {

    Void save(Optional<SubMenuEntity> subMenu);

}
