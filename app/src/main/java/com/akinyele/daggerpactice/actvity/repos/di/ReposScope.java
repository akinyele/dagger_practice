package com.akinyele.daggerpactice.actvity.repos.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author akiny.
 *         Created 3/1/2018.
 *
 *
 *         Dagger by default will create a new instance of every dependency on each call.
 *         This becomes a big problem when we try to create a view.
 *
 *
 *         @Scope - Tells y
 *
 */

@Scope
@Retention(RetentionPolicy.CLASS)
public @interface ReposScope {
}
