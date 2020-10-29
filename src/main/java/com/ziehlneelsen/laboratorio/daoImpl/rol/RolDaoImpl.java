package com.ziehlneelsen.laboratorio.daoImpl.rol;

import com.ziehlneelsen.laboratorio.beans.rol.RolMenuDTO;
import com.ziehlneelsen.laboratorio.dao.rol.RolDAO;
import com.ziehlneelsen.laboratorio.entities.menu.MenuEntity;
import com.ziehlneelsen.laboratorio.entities.rol.RolEntity;
import com.ziehlneelsen.laboratorio.entities.rol.RolMenu;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolDaoImpl implements RolDAO {

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
            Fetch<RolMenu, RolEntity> p = c.fetch("rol");

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

}
