(ns micro-business.uicomponents.uikit.navigationbar
  (:require
   [om.next :as om :refer-macros [defui]]
   [om.dom :as dom]
   [micro-business.uicomponents.uikit.navigationitem :as navigationitem]))

(defn- getNavigationItems [navigationItems]
  (let [navbarNavStyle #js {:className "uk-navbar-nav uk-hidden-small"}]
    (dom/ul navbarNavStyle
            (map navigationitem/navItem navigationItems))))

(defn- getNavbar [{:keys [id brand rightToLeftAlignment navigationItems]}]
  (let [navbarFlipStyle #js {:className "uk-navbar-flip"}
        navbarBrandStyle #js {:className "uk-navbar-brand uk-hidden-small" :href "#"}
        navbarOffCanvasStyle #js {:className "uk-navbar-toggle uk-visible-small" :href (str "#offcanvas-" id) :data-uk-offcanvas ""}
        navbarBrandForSmallDeviceStyle #js {:className "uk-navbar-brand uk-navbar-center uk-visible-small"}]
    (dom/div nil [(dom/a navbarBrandStyle brand)
                  (if rightToLeftAlignment
                    (getNavigationItems navigationItems))
                  (dom/div navbarFlipStyle
                           (getNavigationItems navigationItems))
                  (dom/a navbarOffCanvasStyle)
                  (dom/div navbarBrandForSmallDeviceStyle brand)])))

(defn- getOffCanvasNavigationItems [navigationItems]
  (let [navbarNavStyle #js {:className "uk-nav uk-nav-offcanvas"}]
    (dom/ul navbarNavStyle
            (map navigationitem/navItem navigationItems))))

(defn- getOffCanvasNavbar [{:keys [id brand rightToLeftAlignment navigationItems]}]
  (let [offCanvasDivStyle #js {:className "uk-offcanvas" :id (str "offcanvas-" id)}
        offcanvasDivBarStyle #js {:className "uk-offcanvas-bar"}]
    (dom/div offCanvasDivStyle (dom/div offcanvasDivBarStyle
                                        (getOffCanvasNavigationItems navigationItems)))))

(defui Navbar
  static om/Ident
  (ident [this {:keys [id]}]
         [:navbar/by-id id])

  static om/IQuery
  (query [this]
         (let [navItemSubquery (om/get-query navigationitem/NavItem)]
           `[:id :brand :rightToLeftAlignment {:navigationItems ~navItemSubquery}]))

  Object
  (render [this]
          (let [{:keys [id brand rightToLeftAlignment navigationItems]} (om/props this)
                navbarStyle #js {:className "uk-navbar uk-margin-large-bottom"}]
            (apply dom/nav navbarStyle [(getNavbar {:id id
                                                    :brand brand
                                                    :rightToLeftAlignment rightToLeftAlignment
                                                    :navigationItems navigationItems})
                                        (getOffCanvasNavbar {:id id
                                                             :brand brand
                                                             :rightToLeftAlignment rightToLeftAlignment
                                                             :navigationItems navigationItems})]))))

(def navbar (om/factory Navbar))
