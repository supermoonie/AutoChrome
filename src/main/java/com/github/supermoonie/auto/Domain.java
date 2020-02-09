package com.github.supermoonie.auto;

import com.github.supermoonie.command.*;
import com.github.supermoonie.command.Runtime;

/**
 * @author supermoonie
 * @since 2018/11/9
 */
public interface Domain extends Auto {

    /**
     * get Browser domain
     *
     * @return Browser
     */
    default Browser getBrowser() {
        return (Browser) getThis().getProxy(Browser.class);
    }

    /**
     * get CacheStorage domain
     *
     * @return CacheStorage
     */
    default CacheStorage getCacheStorage() {
        return (CacheStorage) getThis().getProxy(CacheStorage.class);
    }

    /**
     * get Database domain
     *
     * @return Database
     */
    default Database getDatabase() {
        return (Database) getThis().getProxy(Database.class);
    }

    /**
     * get Dom domain
     *
     * @return Dom
     */
    default Dom getDom() {
        return (Dom) getThis().getProxy(Dom.class);
    }

    /**
     * get Emulation domain
     *
     * @return Emulation
     */
    default Emulation getEmulation() {
        return (Emulation) getThis().getProxy(Emulation.class);
    }

    /**
     * get Input domain
     *
     * @return Input
     */
    default Input getInput() {
        return (Input) getThis().getProxy(Input.class);
    }

    /**
     * get Network domain
     *
     * @return Network
     */
    default Network getNetwork() {
        return (Network) getThis().getProxy(Network.class);
    }


    /**
     * get Page domain
     *
     * @return Page
     */
    default Page getPage() {
        return (Page) getThis().getProxy(Page.class);
    }

    /**
     * get Runtime domain
     *
     * @return Runtime
     */
    default Runtime getRuntime() {
        return (Runtime) getThis().getProxy(Runtime.class);
    }

    /**
     * get Security domain
     *
     * @return Security
     */
    default Security getSecurity() {
        return (Security) getThis().getProxy(Security.class);
    }

    /**
     * get Storage domain
     *
     * @return Storage
     */
    default Storage getStorage() {
        return (Storage) getThis().getProxy(Storage.class);
    }

    /**
     * get Target domain
     *
     * @return Target
     */
    default Target getTarget() {
        return (Target) getThis().getProxy(Target.class);
    }
}
