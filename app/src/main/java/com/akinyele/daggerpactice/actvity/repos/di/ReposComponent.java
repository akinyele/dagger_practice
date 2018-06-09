package com.akinyele.daggerpactice.actvity.repos.di;


import com.akinyele.daggerpactice.actvity.repos.ReposActivity;
import com.akinyele.daggerpactice.app.di.component.GithubApplicationComponent;

import dagger.Component;

/**
 * @author akiny.
 * Created 3/1/2018.
 * <p>
 * A component act as a pulbic interface to your dependency graph. Only expose i.e.
 * make public, the classes that you will be using(dependent on).
 * <p>
 * <p>
 * General rule of thumb is that if a component/module has a different life cycle
 * than another one, they should have their own component if your using dagger withing
 * them.
 * <p>
 * @Component - This annotation tells dagger that this interface is a dagger component.
 * NB - The component uses modules to know how to generate the specific dependencies. However,
 * Dagger is unable to bridge connections between components and modules(and it never will)
 * so you need to tell the the component which module(s) is requires.
 */

/*
 *  This tell dagger what scope this component belongs to linking it with all the modules that provides.
 *  dependencies for that scope.
 */
@ReposScope
@Component(modules = {ReposModule.class}, dependencies = {GithubApplicationComponent.class})
public interface ReposComponent {


    /**
     * This lets dagger
     *
     * @param reposActivity
     */
    void inject(ReposActivity reposActivity);
}
