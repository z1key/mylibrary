package org.z1key.projects.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.z1key.projects.entity.Organization;
import org.z1key.projects.entity.Reader;
import org.z1key.projects.service.organization.OrganizationService;
import org.z1key.projects.service.person.ReaderService;
import org.z1key.projects.util.Parser;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reader/")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping("search/i/{id}")
    public String searchUser(@PathVariable("id") long id) {
        Reader reader = readerService.get(id);
        if (reader == null) {
            return "null";
        }
        return reader.toString();
    }

    @RequestMapping("search/l/{login}")
    public String a(@PathVariable("login") String login) {
        Reader reader = readerService.get(login);
        if (reader == null) {
            return "null";
        }
        return reader.toString();
    }
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@RequestParam(name = "firstname", defaultValue = "")String firstName,
                         @RequestParam(name = "middlename", required = false, defaultValue = "") String middleName,
                         @RequestParam(name = "lastname", defaultValue = "") String lastName,
                         @RequestParam(name = "birthdate", required = false) String birthdate,
                         @RequestParam(name = "org", required = false) String org,
                         @RequestParam(name = "login") String login,
                         @RequestParam(name = "password") String password)
    {
        Reader reader = new Reader();
        reader.setFirstName(firstName);
        reader.setLastName(lastName);
        reader.setMiddleName(middleName);
        if (org != null && !org.equals("")) {
            Organization organization = organizationService.getById(Long.parseLong(org));
            reader.setOrganization(organization);
        }
        if (birthdate != null && !birthdate.equals("")) {
            Date date = Parser.parseDate(birthdate);
            reader.setBirthDate(date);
        }
        reader.setMiddleName(middleName);
        reader.setLogin(login);
        reader.setPassword(password);
        return readerService.persist(reader).toString();
    }
    @RequestMapping("find-by-name")
    public String findByName(@RequestParam(name = "firstname", required = false, defaultValue = "") String firstName,
                             @RequestParam(name = "middlename", required = false, defaultValue = "") String middleName,
                             @RequestParam(name = "lastname", required = false, defaultValue = "") String lastName) {
        List<Reader> result = readerService.search(firstName, middleName, lastName);
        StringBuilder sb = new StringBuilder();
        for(Reader r : result) {
            sb.append(r.toString()).append("\n");
        }
        return sb.toString();
    }
}
