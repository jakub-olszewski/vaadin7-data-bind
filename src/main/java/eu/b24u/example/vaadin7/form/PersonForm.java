package eu.b24u.example.vaadin7.form;

import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

/**
 * Form example
 * 
 * @author Jakub Olszewski
 *
 */
public class PersonForm extends FormLayout {
  // Member that will bind to the "name" property
  @PropertyId("name")
  TextField name = new TextField("Name");

  // Member that will bind to the "age" property
  @PropertyId("age")
  TextField ageField = new TextField("Age");

  public PersonForm() {
    // Customize the layout a bit
    setSpacing(true);

    // Add the fields
    addComponent(name);
    addComponent(ageField);
  }
}