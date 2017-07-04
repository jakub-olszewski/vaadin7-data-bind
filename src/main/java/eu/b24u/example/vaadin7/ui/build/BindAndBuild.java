package eu.b24u.example.vaadin7.ui.build;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;

import eu.b24u.example.vaadin7.entity.Person;

/**
 * 
 * Bind and build form
 * 
 * @author Jakub Olszewski
 *
 */
public class BindAndBuild extends FormLayout {

  public BindAndBuild(Person bean) {
    super();

    // Form for editing the bean
    final BeanFieldGroup<Person> binder = new BeanFieldGroup<Person>(Person.class);
    binder.setItemDataSource(bean);

    TextField textFied = (TextField) binder.buildAndBind("Name", "name");
    textFied
        .addValidator(new StringLengthValidator("Please write from 3 to 10 letter", 3, 10, false));

    addComponent(textFied);
    addComponent(binder.buildAndBind("Age", "age"));

    // Buffer the form content
    binder.setBuffered(true);
    addComponent(new Button("OK", new Button.ClickListener() {
      @Override
      public void buttonClick(ClickEvent event) {
        try {
          binder.commit();
          Person person = binder.getItemDataSource().getBean();
          Notification.show(person + "");
          // MyProvider.save(person)
        } catch (CommitException e) {
        }
      }
    }));
  }
}
