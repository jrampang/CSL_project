package presentation;

import persistence.WineGoesWithFood;
import presentation.util.JsfUtil;
import presentation.util.PaginationHelper;
import service.WineGoesWithFoodFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("wineGoesWithFoodController")
@SessionScoped
public class WineGoesWithFoodController implements Serializable {

    private WineGoesWithFood current;
    private DataModel items = null;
    @EJB
    private service.WineGoesWithFoodFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public WineGoesWithFoodController() {
    }

    public WineGoesWithFood getSelected() {
        if (current == null) {
            current = new WineGoesWithFood();
            current.setWineGoesWithFoodPK(new persistence.WineGoesWithFoodPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private WineGoesWithFoodFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (WineGoesWithFood) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new WineGoesWithFood();
        current.setWineGoesWithFoodPK(new persistence.WineGoesWithFoodPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            recreateModel();
            current.getWineGoesWithFoodPK().setWineId(current.getWine().getWineId());
            current.getWineGoesWithFoodPK().setFoodName(current.getFood().getFoodName());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("WineGoesWithFoodCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (WineGoesWithFood) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getWineGoesWithFoodPK().setWineId(current.getWine().getWineId());
            current.getWineGoesWithFoodPK().setFoodName(current.getFood().getFoodName());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("WineGoesWithFoodUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (WineGoesWithFood) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("WineGoesWithFoodDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public WineGoesWithFood getWineGoesWithFood(persistence.WineGoesWithFoodPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = WineGoesWithFood.class)
    public static class WineGoesWithFoodControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            WineGoesWithFoodController controller = (WineGoesWithFoodController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "wineGoesWithFoodController");
            return controller.getWineGoesWithFood(getKey(value));
        }

        persistence.WineGoesWithFoodPK getKey(String value) {
            persistence.WineGoesWithFoodPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new persistence.WineGoesWithFoodPK();
            key.setFoodName(values[0]);
            key.setWineId(values[1]);
            return key;
        }

        String getStringKey(persistence.WineGoesWithFoodPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getFoodName());
            sb.append(SEPARATOR);
            sb.append(value.getWineId());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof WineGoesWithFood) {
                WineGoesWithFood o = (WineGoesWithFood) object;
                return getStringKey(o.getWineGoesWithFoodPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + WineGoesWithFood.class.getName());
            }
        }

    }

}
