package com.ziehlneelsen.laboratorio.daoImpl.rol;

import com.ziehlneelsen.laboratorio.beans.rol.RolMenuDTO;
import com.ziehlneelsen.laboratorio.beans.rol.RolSubMenuDTO;
import com.ziehlneelsen.laboratorio.dao.rol.RolDAO;
import com.ziehlneelsen.laboratorio.entities.menu.MenuEntity;
import com.ziehlneelsen.laboratorio.entities.menu.SubMenuEntity;
import com.ziehlneelsen.laboratorio.entities.rol.RolEntity;
import com.ziehlneelsen.laboratorio.entities.rol.RolMenu;
import com.ziehlneelsen.laboratorio.entities.rol.RolSubmenu;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolDAOImpl implements RolDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");

    @Override
    public RolMenuDTO findMenuByRol(Integer rolId) {

        EntityManager em = emf.createEntityManager();
        List<RolMenu> listRolMenu = new ArrayList<>();
        List<MenuEntity> listMenu = new ArrayList<>();

        RolMenuDTO rolMenu = new RolMenuDTO();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<RolMenu> query = cb.createQuery(RolMenu.class);

            Root<RolMenu> c = query.from(RolMenu.class);
            Fetch<RolMenu, MenuEntity> p = c.fetch("rol");

            Predicate idRol = cb.equal(c.get("rol").get("rolId"), rolId);

            query.select(c).where(idRol);

            listRolMenu = em.createQuery(query).getResultList();
            listRolMenu.forEach((menu) -> {
                listMenu.add(menu.getMenu());
            });

            rolMenu.setRol(listRolMenu.get(0).getRol());
            rolMenu.setMenu(listMenu);

        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return rolMenu;

    }

    @Override
    public RolSubMenuDTO findSubMenuByRol(Integer rolId) {

        EntityManager em = emf.createEntityManager();
        List<RolSubmenu> listRolMenu = new ArrayList<>();
        List<SubMenuEntity> listMenu = new ArrayList<>();

        RolSubMenuDTO rolMenu = new RolSubMenuDTO();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<RolSubmenu> query = cb.createQuery(RolSubmenu.class);

            Root<RolSubmenu> c = query.from(RolSubmenu.class);
            Fetch<RolSubmenu, RolEntity> p = c.fetch("rol");

            Predicate idRol = cb.equal(c.get("rol").get("rolId"), rolId);

            query.select(c).where(idRol);

            if (!listMenu.isEmpty()){
                listRolMenu = em.createQuery(query).getResultList();
                listRolMenu.forEach((menu) -> {
                    listMenu.add(menu.getSubMenu());
                });

                rolMenu.setRol(listRolMenu.get(0).getRol());
                rolMenu.setSubMenu(listMenu);
            }

        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return rolMenu;

    }

}
