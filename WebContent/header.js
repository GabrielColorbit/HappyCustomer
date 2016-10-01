(function(angular) {
  'use strict';
function HeaderController() {

}

angular.module('happyCustomerApp').component('header', {
  templateUrl: 'header.html',
  controller: HeaderController,
  bindings: {
    header: '='
  }
});
})(window.angular);
