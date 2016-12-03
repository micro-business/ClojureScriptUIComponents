(ns micro-business.uicomponents.uikit.navbar.navigationbar
  (:require
   [om.next :as om :refer-macros [defui]]
   [om.dom :as dom]
   [micro-business.uicomponents.uikit.navbar.navigationitem :as navigationitem]))

(defn- getNavigationItems [navigationItems]
  (let [navBarNavStyle #js {:className "uk-navbar-nav uk-hidden-small"}]
    (dom/ul navBarNavStyle
            (map navigationitem/navItem navigationItems))))

(defn- getNavBar [{:keys [id brand rightToLeftAlignment navigationItems]}]
  (let [navBarFlipStyle #js {:className "uk-navbar-flip"}
        navBarBrandStyle #js {:className "uk-navbar-brand uk-hidden-small" :href "#"}
        navBarOffCanvasStyle #js {:className "uk-navbar-toggle uk-visible-small" :href (str "#offcanvas-" id) :data-uk-offcanvas ""}
        navBarBrandForSmallDeviceStyle #js {:className "uk-navbar-brand uk-navbar-center uk-visible-small"}]
    (dom/div nil [(dom/a navBarBrandStyle brand)
                  (if rightToLeftAlignment
                    (getNavigationItems navigationItems))
                  (dom/div navBarFlipStyle
                           (getNavigationItems navigationItems))
                  (dom/a navBarOffCanvasStyle)
                  (dom/div navBarBrandForSmallDeviceStyle brand)])))

(defn- getOffCanvasNavigationItems [navigationItems]
  (let [navBarNavStyle #js {:className "uk-nav uk-nav-offcanvas"}]
    (dom/ul navBarNavStyle
            (map navigationitem/navItem navigationItems))))

(defn- getOffCanvasNavBar [{:keys [id brand rightToLeftAlignment navigationItems]}]
  (let [offCanvasDivStyle #js {:className "uk-offcanvas" :id (str "offcanvas-" id)}
        offcanvasDivBarStyle #js {:className "uk-offcanvas-bar"}]
    (dom/div offCanvasDivStyle (dom/div offcanvasDivBarStyle
                                        (getOffCanvasNavigationItems navigationItems)))))

(defui NavBar
  static om/Ident
  (ident [this {:keys [id]}]
         [:navBar/by-id id])

  static om/IQuery
  (query [this]
         (let [navItemSubquery (om/get-query navigationitem/NavItem)]
           `[:id :brand :rightToLeftAlignment {:navigationItems ~navItemSubquery}]))

  Object
  (render [this]
          (let [{:keys [id brand rightToLeftAlignment navigationItems]} (om/props this)
                navBarStyle #js {:className "uk-navbar uk-margin-large-bottom"}]
            (apply dom/nav navBarStyle [(getNavBar {:id id
                                                    :brand brand
                                                    :rightToLeftAlignment rightToLeftAlignment
                                                    :navigationItems navigationItems})
                                        (getOffCanvasNavBar {:id id
                                                             :brand brand
                                                             :rightToLeftAlignment rightToLeftAlignment
                                                             :navigationItems navigationItems})]))))

(def navBar (om/factory NavBar))
