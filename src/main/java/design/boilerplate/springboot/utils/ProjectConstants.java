package design.boilerplate.springboot.utils;

import java.util.Locale;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
public final class ProjectConstants {

	// FIXME : Customize project constants for your application.

	public static final String DEFAULT_ENCODING = "UTF-8";
	
	public static final Long[] USER_ROLE_TYPE_ID_ARRAY = {1L, 2L, 3L};
	
	public static final Long[] COMPANY_TYPE_ID_ARRAY = {1L, 2L, 3L}; 

	public static final String PROJECT_BASE_PACKAGE = "design.boilerplate.springboot";

	public static final Locale TURKISH_LOCALE = new Locale.Builder().setLanguage("tr").setRegion("TR").build();
	
	public static final String ACTIVE_STATUS = "ACTIVE";
	
	public static final String INACTIVE_STATUS = "INACTIVE";

	private ProjectConstants() {

		throw new UnsupportedOperationException();
	}

}
