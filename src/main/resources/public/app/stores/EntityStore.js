Ext.define('app.stores.EntityStore', {
    extend: 'Ext.data.Store',
    requires: [
        'app.models.Entity',
        'app.stores.AppRestProxy'
    ],

    model: 'app.models.Entity',

    autoLoad: true,

    remoteFilter: true,

    proxy: {
        type: 'app-rest',
        url: '/entity',
        api: {
            read: 'entity/query'
        }
    }

});