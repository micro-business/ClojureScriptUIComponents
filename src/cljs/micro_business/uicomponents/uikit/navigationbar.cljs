(ns micro-business.uicomponents.uikit.navigationbar
  (:require
   [om.next :as om :refer-macros [defui]]
   [om.dom :as dom]
   [micro-business.uicomponents.uikit.navigationitem :as navigationitem]))

(defn- getNavigationItems [navigationItems]
  (let [navbarNavStyle #js {:className "uk-navbar-nav uk-hidden-small"}]
    (dom/ul navbarNavStyle
            (map navigationitem/navItem navigationItems))))

(defn- getNavbar [{:keys [brand rightToLeftAlignment navigationItems]}]
  (let [navbarStyle #js {:className "uk-navbar uk-margin-large-bottom"}
        navbarFlipStyle #js {:className "uk-navbar-flip"}
        navbarBrandStyle #js {:className "uk-navbar-brand uk-hidden-small" :href "#"}
        navbarOffCanvasStyle #js {:className "uk-navbar-toggle uk-visible-small" :href "#offcanvas" :data-uk-offcanvas ""}
        navbarBrandForSmallDeviceStyle #js {:className "uk-navbar-brand uk-navbar-center uk-visible-small" :href "#"}]
    (apply dom/nav navbarStyle [(dom/a navbarBrandStyle brand)
                                (if rightToLeftAlignment
                                  (getNavigationItems navigationItems))
                                (dom/div navbarFlipStyle
                                         (getNavigationItems navigationItems))
                                (dom/a navbarOffCanvasStyle)
                                (dom/a navbarBrandForSmallDeviceStyle brand)])))

(defui Navbar
  static om/IQuery
  (query [this]
         (let [navItemSubquery (om/get-query navigationitem/NavItem)]
           `[:brand :rightToLeftAlignment {:navigationitems ~navItemSubquery}]))
  Object
  (render [this]
          (getNavbar {:brand (-> this om/props :brand)
                      :rightToLeftAlignment (-> this om/props :rightToLeftAlignment)
                      :navigationItems (-> this om/props :navigationItems)})))

(def navbar (om/factory Navbar))
