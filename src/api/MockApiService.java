package api;

import java.util.ArrayList;
import java.util.List;

import models.Template;

public class MockApiService implements ApiService {

	@Override
	public List<Template> getTemplates() {
		List<Template> templates = new ArrayList<Template>();
		Template t1 = new Template();
		t1.setId(1);
		t1.setText("Police alert");
		Template t2 = new Template();
		t2.setId(1);
		t2.setText("Breathalyzer check alert");
		templates.add(t1);
		templates.add(t2);
		return templates;
	}
}
