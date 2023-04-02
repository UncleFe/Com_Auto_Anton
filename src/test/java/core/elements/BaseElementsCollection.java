package core.elements;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class BaseElementsCollection {
    private ElementsCollection elements;
    private String name;

    public BaseElementsCollection(By locator, String collectionName){
        elements = $$(locator);
        name = collectionName;
    }

    public BaseElementsCollection(ElementsCollection elements, String collectionName){
        this.elements = elements;
        name = collectionName;
    }

    public ElementsCollection getElements() {
        System.out.println(String.format("Get elements of elements collection %s", name));
        return elements;
    }
    public List<String> getTexts(){
        System.out.println(String.format("Get texts of elements collection %s", name));
        return elements.texts();
    }
    public BaseElement get(int id){
        System.out.println(String.format("Get element with id %d of elements collection %s", id, name));
        return new BaseElement(elements.get(id), String.format("Element [%d] of collection %s", id, name));
    }
    public BaseElement getByText(String text){
        System.out.println(String.format("Get element with text %s of elements collection %s", text, name));
        return get(getTexts().indexOf(text));
    }

    public BaseElement getByAttribute(String attributeName, String attributeText){
        System.out.println(String.format("Get element with text %s attribute %s elements collection %s",
                attributeName, attributeText, name));
        int idx = -1;
        for(int i = 0; i < elements.size(); ++i){
            if(elements.get(i).getAttribute(attributeName).equals(attributeText)){
                idx = i;
            }
        }
        return new BaseElement(elements.get(idx),
                String.format("Element of collection %s with attribute %s = %s", name, attributeName, attributeText));
    }
}
