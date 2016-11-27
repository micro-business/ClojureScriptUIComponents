(ns micro-business.uicomponents
  (:require
   [goog.dom :as gdom]
   [om.next :as om :refer-macros [defui]]
   [om.dom :as dom]
   [micro-business.state :as state]
   [micro-business.reader :as reader]
   [micro-business.mutate :as mutate]
   [micro-business.uicomponents.uikit.navigationbar :as navigationbar]))

(enable-console-print!)

(defui NavbarRootView
  static om/IQuery
  (query [this]
         (let [navbarSubquery (om/get-query navigationbar/Navbar)]
           `[{:navigationBar ~navbarSubquery}]))
  Object
  (render [this]
          (let [{:keys [navigationBar]} (om/props this)
                rootViewStyle #js {:className "uk-container uk-container-center uk-margin-top"}]
            (dom/div
             rootViewStyle
             (navigationbar/navbar navigationBar)))))

(def navbarRootViewReconciler
  (om/reconciler
   {:state state/applicationGlobalState
    :parser (om/parser {:read reader/read :mutate mutate/mutate})}))

(defn ^:export renderNavbarRootView [elementName]
  (om/add-root! navbarRootViewReconciler
                NavbarRootView (gdom/getElement elementName)))

(renderNavbarRootView "navbarView")
