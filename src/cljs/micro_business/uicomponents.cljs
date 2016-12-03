(ns micro-business.uicomponents
  (:require
   [goog.dom :as gdom]
   [om.next :as om :refer-macros [defui]]
   [om.dom :as dom]
   [micro-business.state :as state]
   [micro-business.reader :as reader]
   [micro-business.mutate :as mutate]
   [micro-business.uicomponents.uikit.navbar.navigationbar :as navigationbar]))

(enable-console-print!)

(defui NavBarRootView
  static om/IQuery
  (query [this]
         (let [navBarSubquery (om/get-query navigationbar/NavBar)]
           `[{:navigationBars ~navBarSubquery}]))
  Object
  (render [this]
          (let [{:keys [navigationBars]} (om/props this)
                rootViewStyle #js {:className "uk-container uk-container-center uk-margin-top"}]
            (dom/div
             rootViewStyle
             (map navigationbar/navBar navigationBars)))))

(def navBarRootViewReconciler
  (om/reconciler
   {:state state/applicationGlobalState
    :parser (om/parser {:read reader/read :mutate mutate/mutate})}))

(defn ^:export renderNavBarRootView [elementName]
  (om/add-root! navBarRootViewReconciler
                NavBarRootView (gdom/getElement elementName)))

(renderNavBarRootView "navBarView")
