
package foodsystem_lapizzeria;

/**
 *
 * @author A
 */
class FoodCategory {
    
   // private int menu_id;
    private String menu_title;
    
    
    public FoodCategory( String menu_title) {
       // this.menu_id = menu_id;
        this.menu_title = menu_title;
    }

   

    public String getMenu_title() {
        return menu_title;
    }

    public void setMenu_title(String menu_title) {
        this.menu_title = menu_title;
    }
    
    public String toString(){
        return (menu_title);
    }
    
    
}
