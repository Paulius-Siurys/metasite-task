(function () {

	var am = angular.module('metasite');

	am.service('fileUploadService', ['$http', function ($http) {
        this.uploadFileToUrl = function(file) {
            var fd = new FormData();
            fd.append('file', file);
            $http.post('action/file/upload', fd, {
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            })
            .success(function(){
            })
            .error(function(){
            });
        };
    }]);
})();