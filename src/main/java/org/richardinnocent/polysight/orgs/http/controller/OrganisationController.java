package org.richardinnocent.polysight.orgs.http.controller;

import java.util.Set;
import org.richardinnocent.polysight.orgs.models.Organisation;
import org.richardinnocent.polysight.orgs.services.OrganisationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(produces = "application/json")
public class OrganisationController {

  private final OrganisationService organisationService;

  private OrganisationController(OrganisationService organisationService) {
    this.organisationService = organisationService;
  }

  @GetMapping("organisations")
  @SuppressWarnings("unused")
  public String organisations(Model model) {
    Set<Organisation> organisations =
        organisationService.getAllOrganisationsForUserWithId(1L);
    model.addAttribute("organisations", organisations);
    return "organisations";
  }

}
