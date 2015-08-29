'use strict';

describe('Controller: MakeCtrl', function () {

  // load the controller's module
  beforeEach(module('publicApp'));

  var MakeCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    MakeCtrl = $controller('MakeCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(MakeCtrl.awesomeThings.length).toBe(3);
  });
});
