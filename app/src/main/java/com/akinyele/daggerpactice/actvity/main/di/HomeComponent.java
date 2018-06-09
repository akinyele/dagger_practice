package com.akinyele.daggerpactice.actvity.main.di;

import com.akinyele.daggerpactice.actvity.main.HomeActivity;
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
 *      Dagger is unable to bridge connections between components and modules(and it never will)
 *      so you need to tell the the component which module(s) is requires.
 */

/*
 *  This tell dagger what scope this component belongs to linking it with all the modules that provides.
 *  dependencies for that scope.
 */
@HomeScope
@Component(modules = {HomeModule.class}, dependencies = {GithubApplicationComponent.class})
public interface HomeComponent {


    /**
     * This lets dagger
     *
     * @param homeActivity
     */
    void inject(HomeActivity homeActivity);
}
