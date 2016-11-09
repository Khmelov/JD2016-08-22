package by.it.shkantau.project.java.controller;

import by.it.shkantau.project.java.beans.*;
import by.it.shkantau.project.java.connection.ConnectionSettings;
import by.it.shkantau.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

class SessionAttrSesHelper {

    @SuppressWarnings("unchecked")
    static void setRolesToAttribute(HttpServletRequest request){
        Object o = request.getSession().getAttribute("roles");
        if (o != null) {
            if (o instanceof List) {
                List<Role> roleList = (List<Role>) o;
                request.setAttribute("roles", roleList);
            }
        }else {
            DAO dao = DAO.getDAO();
            List<Role> roles = dao.roleDAO.getAll("");
            request.setAttribute("roles",roles);
            request.getSession().setAttribute("roles",roles);
        }
    }
    @SuppressWarnings("unchecked")
    static void setPilotsToAttribute(HttpServletRequest request){
        Object o = request.getSession().getAttribute("pilots");
        if (o != null) {
            if (o instanceof List) {
                List<Pilot> pilotList = (List<Pilot>) o;
                request.setAttribute("pilots", pilotList);
            }
        }else {
            DAO dao = DAO.getDAO();
            List<Pilot> roles = dao.pilotDAO.getAll("");
            request.setAttribute("pilots",roles);
            request.getSession().setAttribute("pilots",roles);
        }
    }
    @SuppressWarnings("unchecked")
    static void setAirhostessToAttribute(HttpServletRequest request){
        Object o = request.getSession().getAttribute("airhostesses");
        List<Airhostess> airhostesses;
        if (o != null) {
            if (o instanceof List) {
                airhostesses = (List<Airhostess>) o;
                request.setAttribute("airhostesses", airhostesses);
            }
        }else {
            DAO dao = DAO.getDAO();
            airhostesses = dao.airhostessDAO.getAll("");
            request.setAttribute("airhostesses",airhostesses);
            request.getSession().setAttribute("airhostesses",airhostesses);
        }
    }
    @SuppressWarnings("unchecked")
    static void setAirportsToAttribute(HttpServletRequest request){
        Object o = request.getSession().getAttribute("airports");
        List<Airport> airports;
        if (o != null) {
            if (o instanceof List) {
                airports = (List<Airport>) o;
                request.setAttribute("airports", airports);
            }
        }else {
            DAO dao = DAO.getDAO();
            airports = dao.airportsDAO.getAll("");
            request.setAttribute("airports",airports);
            request.getSession().setAttribute("airports",airports);
        }
    }
    @SuppressWarnings("unchecked")
    static void setPlanesToAttribute(HttpServletRequest request){
        Object o = request.getSession().getAttribute("planes");
        List<Plane> planes;
        if (o != null) {
            if (o instanceof List) {
                planes = (List<Plane>) o;
                request.setAttribute("planes", planes);
            }
        }else {
            DAO dao = DAO.getDAO();
            planes = dao.planeDAO.getAll("");
            request.setAttribute("planes", planes);
            request.getSession().setAttribute("planes", planes);
        }
    }
    @SuppressWarnings("unchecked")
    static void setCrewsToAttribute(HttpServletRequest request){
        Object o = request.getSession().getAttribute("crews");
        List<Crew> crews;
        if (o != null) {
            if (o instanceof List) {
                crews = (List<Crew>) o;
                request.setAttribute("crews", crews);
            }
        }else {
            DAO dao = DAO.getDAO();
            crews = dao.crewDAO.getAll("");
            request.setAttribute("crews", crews);
            request.getSession().setAttribute("crews", crews);
        }
    }
    @SuppressWarnings("unchecked")
    static void setCommandToAttribute(HttpServletRequest request){
        Object o = request.getSession().getAttribute("commands");
        List<Command> commands;
        if (o != null) {
            if (o instanceof List) {
                commands = (List<Command>) o;
                request.setAttribute("commands", commands);
            }
        }else {
            DAO dao = DAO.getDAO();
            commands = dao.commandDAO.getAll("");
            request.setAttribute("commands", commands);
            request.getSession().setAttribute("commands", commands);
        }
    }
    @SuppressWarnings("unchecked")
    static void setPermissionToAttribute(HttpServletRequest request){
        Object o = request.getSession().getAttribute("permissions");
        List<Permission> permissions;
        if (o != null) {
            if (o instanceof List) {
                permissions = (List<Permission>) o;
                request.setAttribute("permissions", permissions);
            }
        }else {
            DAO dao = DAO.getDAO();
            permissions = dao.permissionDAO.getAll("");
            request.setAttribute("permissions", permissions);
            request.getSession().setAttribute("permissions", permissions);
        }
    }

    static boolean isAdministrator(HttpServletRequest request){
        HttpSession session = request.getSession();
        Object o = session.getAttribute("user");
        if (o != null){
            if (o instanceof User){
                return ((User) o).getRole() == Role.ADMINISTRATOR_ROLE;
            }
        }
        return false;
    }

    static boolean isLogined(HttpServletRequest request){
        HttpSession session = request.getSession();
        Object o = session.getAttribute("user");
        if (o != null){
            if (o instanceof User){
                    return true;
            }
        }
        return false;
    }
    
}
