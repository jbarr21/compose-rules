// Copyright 2023 Nacho Lopez
// SPDX-License-Identifier: Apache-2.0
package io.nlopez.compose.rules.detekt

import io.gitlab.arturbosch.detekt.api.Config
import io.nlopez.compose.core.ComposeKtVisitor
import io.nlopez.compose.rules.DetektRule
import io.nlopez.compose.rules.Naming

class NamingCheck(config: Config) :
    DetektRule(config, DESCRIPTION),
    ComposeKtVisitor by Naming() {

    override val ruleId = Id("ComposableNaming")

    private companion object {
        private val DESCRIPTION = """
        Composable functions that return Unit should start with an uppercase letter. They are considered declarative entities that can be either present or absent in a composition and therefore follow the naming rules for classes.

        However, Composable functions that return a value should start with a lowercase letter instead. They should follow the standard Kotlin Coding Conventions for the naming of functions for any function annotated @Composable that returns a value other than Unit
        """.trimIndent()
    }
}
