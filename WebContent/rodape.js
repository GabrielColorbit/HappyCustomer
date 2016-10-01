(function(angular) {
  'use strict';
function HeaderController() {

}

angular.module('happyCustomerApp').component('rodape', {
  templateUrl: 'footer.html',
  controller: HeaderController,
  bindings: {
    footer: '='
  }
});
})(window.angular);

