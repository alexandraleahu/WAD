package ro.infoiasi.wad.sesi.client.companies;

import com.github.gwtbootstrap.client.ui.Label;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import ro.infoiasi.wad.sesi.client.commonwidgets.widgetinterfaces.ResourceWidgetViewer;
import ro.infoiasi.wad.sesi.core.model.Company;

public class CompanyView extends Composite implements ResourceWidgetViewer<Company> {
    @Override
    public void edit(Company bean) {
        driver.edit(bean);

        companyUrl.setText(bean.getSiteUrl());
        description.setText(bean.getDescription());
        name.setText(bean.getName());
        communityRating.setText(String.valueOf(bean.getCommunityRating()));
        if (bean.isActive()) {
            active.setText("Yes");
        } else {
            active.setText("No");
        }
    }

    interface CompanyViewUiBinder extends UiBinder<HTMLPanel, CompanyView> {
    }

    // Empty interface declaration, similar to UiBinder
    interface Driver extends SimpleBeanEditorDriver<Company, CompanyView> {
    }

    Driver driver = GWT.create(Driver.class);
    private static CompanyViewUiBinder ourUiBinder = GWT.create(CompanyViewUiBinder.class);
    @UiField
    @Path("communityRating")
    @Ignore
    Label communityRating;

    @UiField
    @Path("siteUrl")
    Label companyUrl;

    @UiField
    @Path("active")
    @Ignore
    Label active;

    @UiField
    @Path("description")
    Label description;

    @UiField
    @Path("name")
    Label name;

    public CompanyView() {
        initWidget(ourUiBinder.createAndBindUi(this));
        driver.initialize(this);
    }
}