package br.com.vertigo.config;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(
        category = "category-b3",
        scope = ExtendedObjectClassDefinition.Scope.SYSTEM
)
@Meta.OCD(id = "br.com.vertigo.config.FinderConfiguration")
public interface FinderConfiguration {

    @Meta.AD(required = false)
    public String templateId();

    @Meta.AD(required = false)
    public String vocabularyId();

}