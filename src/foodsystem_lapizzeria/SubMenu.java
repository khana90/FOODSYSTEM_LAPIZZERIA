
package foodsystem_lapizzeria;

/**
 *
 * @author A
 */
public class SubMenu {
   private  String title;
   private String menu_category; 
     
    public SubMenu(String title, String menu_category) {
        this.title = title;
        this.menu_category = menu_category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMenu_category() {
        return menu_category;
    }

    public void setMenu_category(String menu_category) {
        this.menu_category = menu_category;
    }
  
    
}
