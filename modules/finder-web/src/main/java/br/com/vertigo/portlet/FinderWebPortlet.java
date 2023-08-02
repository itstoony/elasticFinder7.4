package br.com.vertigo.portlet;

import br.com.vertigo.constants.FinderWebPortletKeys;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetVocabularyLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author vertigo
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=FinderWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + FinderWebPortletKeys.FINDERWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FinderWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		try {

			ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
			long companyId = serviceContext.getCompanyId();

			List<AssetVocabulary> companyVocabularies = assetVocabularyLocalService.getCompanyVocabularies(companyId);

			List<AssetVocabulary> listaFiltrada = new ArrayList<>();

			companyVocabularies.forEach( cv -> {
				if (!cv.getUserName().isEmpty()) {
					listaFiltrada.add(cv);
				}
			});

			Map<String, List<AssetCategory>> categoriasTags =  new HashMap<>();

			listaFiltrada.forEach(li -> {

                List<AssetCategory> lista = new ArrayList<>(li.getCategories());

				categoriasTags.put(li.getTitle(Locale.US), lista);
			});


			renderRequest.setAttribute("categorias", categoriasTags);

		} catch (PortalException e) {
			throw new RuntimeException(e);
		}


		super.render(renderRequest, renderResponse);
	}

	@Reference
	protected AssetVocabularyLocalService assetVocabularyLocalService;

}