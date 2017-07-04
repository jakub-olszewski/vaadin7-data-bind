package eu.b24u.example.vaadin7.ui.build;

import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;

import eu.b24u.example.vaadin7.entity.Person;
import eu.b24u.example.vaadin7.form.PersonForm;

public class BindWithForm extends FormLayout {

  public BindWithForm(Person person) {
    // form to bind
    PersonForm personForm = new PersonForm();

    FieldGroup binder = new FieldGroup(buildItemProperty(person));
    binder.bindMemberFields(personForm);

    // add all form with fields
    addComponent(personForm);
    addComponent(new Button("OK", new Button.ClickListener() {
      @Override
      public void buttonClick(ClickEvent event) {
        try {
          binder.commit();
          Person person = buildModel(binder.getItemDataSource());
          Notification.show(person + "");
          // MyProvider.save(person)
        } catch (CommitException e) {
        }
      }
    }));
  }

  public PropertysetItem buildItemProperty(Person person) {
    PropertysetItem item = new PropertysetItem();
    item.addItemProperty("name", new ObjectProperty<String>(person.getName()));
    item.addItemProperty("age", new ObjectProperty<Integer>(person.getAge()));
    return item;
  }

  public Person buildModel(Item item) {
    Person person = new Person();
    person.setName((String) item.getItemProperty("name").getValue());
    person.setAge((int) item.getItemProperty("age").getValue());

    return person;
  }

}
