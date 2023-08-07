package br.com.vertigo.action;

import br.com.vertigo.constants.FinderWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + FinderWebPortletKeys.FINDERWEB,
                "mvc.command.name=/configuration"
        },
        service = MVCRenderCommand.class
)
public class CustomConfigurationRenderCommand implements MVCRenderCommand {

    @Override
    public String render(
            RenderRequest renderRequest, RenderResponse renderResponse)
            throws PortletException {

        System.out.println("Chegou aqui!");

        renderRequest.setAttribute("meuAtributo", "valorDoAtributo");

        return "/configuration.jsp";
    }
}