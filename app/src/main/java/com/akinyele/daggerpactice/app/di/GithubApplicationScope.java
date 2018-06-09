package com.akinyele.daggerpactice.app.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author akiny.
 *         Created 2/28/2018.
 */


@Scope
@Retention(RetentionPolicy.CLASS)
public @interface GithubApplicationScope {
}
