package com.ziehlneelsen.laboratorio.daoImpl.menu;

import com.ziehlneelsen.laboratorio.beans.menu.MenuSubmenuDTO;
import com.ziehlneelsen.laboratorio.dao.menu.MenuDao;
import com.ziehlneelsen.laboratorio.entities.menu.MenuEntity;
import com.ziehlneelsen.laboratorio.entities.menu.MenuSubmenu;
import com.ziehlneelsen.laboratorio.entities.menu.SubMenuEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuDAOImpl implements MenuDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");


    @Override
    public MenuSubmenuDTO getSubmenuByMenu(Integer menuId) {
        EntityManager em = emf.createEntityManager();
        List<MenuSubmenu> listMenuSubmenu = new ArrayList<>();
        List<SubMenuEntity> listSubMenu = new ArrayList<>();

        MenuSubmenuDTO menuSubmenu = new MenuSubmenuDTO();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<MenuSubmenu> query = cb.createQuery(MenuSubmenu.class);

            Root<MenuSubmenu> c = query.from(MenuSubmenu.class);
            Fetch<MenuSubmenu, MenuEntity> p = c.fetch("menu");

            Predicate idRol = cb.equal(c.get("menu").get("menuId"), menuId);

            query.select(c).where(idRol);



            listMenuSubmenu = em.createQuery(query).getResultList();
            listMenuSubmenu.forEach((menu) -> {
                listSubMenu.add(menu.getSubMenu());
            });

            menuSubmenu.setMenu(listMenuSubmenu.get(0).getMenu());
            menuSubmenu.setSubMenu(listSubMenu);

        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return menuSubmenu;
    }

}
