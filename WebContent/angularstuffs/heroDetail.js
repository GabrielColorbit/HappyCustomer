(function(angular) {
  'use strict';
function HeroDetailController() {

}

angular.module('heroApp').component('heroDetail', {
  templateUrl: 'heroDetail.html',
  controller: HeroDetailController,
  bindings: {
    hero: '='
  }
});
angular.module('heroApp').component('heroDetail2', {
  templateUrl: 'header.html',
  controller: HeroDetailController,
  bindings: {
    hero2: '='
  }
});
})(window.angular);

/*
Copyright 2016 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/