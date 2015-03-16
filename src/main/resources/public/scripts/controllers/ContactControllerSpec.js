describe('Contact Controller should', function () {
    beforeEach(module('contactApp'));

    var scope;
    beforeEach(inject(function ($rootScope, $controller) {
        scope = $rootScope.$new();
        $controller('ContactController', {
            $scope: scope
        });
    }));

    it("switches modes", function () {
        scope.switchToMode('/edit');

        expect(scope.editMode).toBeTruthy();
    });
});
