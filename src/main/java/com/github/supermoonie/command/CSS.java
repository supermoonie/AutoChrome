package com.github.supermoonie.command;

import com.github.supermoonie.annotation.Domain;
import com.github.supermoonie.annotation.Experimental;
import com.github.supermoonie.annotation.Param;
import com.github.supermoonie.annotation.Returns;
import com.github.supermoonie.type.css.*;

import java.util.List;

/**
 * This domain exposes CSS read/write operations.
 * All CSS objects (stylesheets, rules, and styles) have an associated id used in subsequent operations on the related object.
 * Each object type has a specific id structure, and those are not interchangeable between objects of different kinds.
 * CSS objects can be loaded using the get*ForNode() calls (which accept a DOM node id).
 * A client can also keep track of stylesheets via the styleSheetAdded/styleSheetRemoved events and subsequently load the required stylesheet contents using the getStyleSheet[Text]() methods.
 *
 * @author supermoonie
 * @date 2018/11/7 17:48
 */
@Experimental
@Domain("CSS")
public interface CSS {

    /**
     * Inserts a new rule with the given <code>ruleText</code>in a stylesheet with given<code>styleSheetId</code>, at the
     * position specified by <code>location</code>.
     *
     * @param styleSheetId The css style sheet identifier where a new rule should be inserted.
     * @param ruleText     The text of a new rule.
     * @param location     Text position of a new rule in the target style sheet.
     * @return The newly created rule.
     */
    @Returns("rule")
    CSSRule addRule(@Param("styleSheetId") String styleSheetId,
                    @Param("ruleText") String ruleText,
                    @Param("location") SourceRange location);

    /**
     * Returns all class names from specified stylesheet.
     *
     * @param styleSheetId styleSheet id
     * @return Class name list.
     */
    @Returns("classNames")
    List<String> collectClassNames(@Param("styleSheetId") String styleSheetId);

    /**
     * Creates a new special "via-inspector" stylesheet in the frame with given frameId.
     *
     * @param frameId Identifier of the frame where "via-inspector" stylesheet should be created.
     * @return Identifier of the created "via-inspector" stylesheet.
     */
    @Returns("styleSheetId")
    String createStyleSheet(@Param("frameId") String frameId);

    /**
     * Disables the CSS agent for the given page.
     */
    void disable();

    /**
     * Enables the CSS agent for the given page. Clients should not assume that the CSS agent has been
     * enabled until the result of this command is received.
     */
    void enable();

    /**
     * Ensures that the given node will have specified pseudo-classes whenever its style is computed by
     * the browser.
     *
     * @param nodeId              The element id for which to force the pseudo state.
     * @param forcedPseudoClasses Element pseudo classes to force when computing the element's style.
     */
    void forcePseudoState(@Param("nodeId") Integer nodeId,
                          @Param("forcedPseudoClasses") List<String> forcedPseudoClasses);

    /**
     * getBackgroundColors
     *
     * @param nodeId Id of the node to get background colors for.
     * @return GetBackgroundColorsResult
     */
    GetBackgroundColorsResult getBackgroundColors(@Param("nodeId") int nodeId);

    /**
     * Returns the computed style for a DOM node identified by <code>nodeId</code>.
     *
     * @param nodeId Id of the node to get background colors for.
     * @return Computed style for the specified DOM node.
     */
    @Returns("computedStyle")
    List<CSSComputedStyleProperty> getComputedStyleForNode(@Param("nodeId") int nodeId);

    /**
     * Returns the styles defined inline (explicitly in the "style" attribute and implicitly, using DOM attributes) for a DOM node identified by nodeId.
     *
     * @param nodeId Id of the node to get background colors for.
     * @return GetInlineStylesForNodeResult
     */
    GetInlineStylesForNodeResult getInlineStylesForNode(@Param("nodeId") int nodeId);

    /**
     * Returns requested styles for a DOM node identified by <code>nodeId</code>.
     *
     * @param nodeId Id of the node to get background colors for.
     * @return GetMatchedStylesForNodeResult
     */
    GetMatchedStylesForNodeResult getMatchedStylesForNode(@Param("nodeId") int nodeId);

    /**
     * Returns all media queries parsed by the rendering engine.
     *
     * @return medias
     */
    @Returns("medias")
    List<CSSMedia> getMediaQueries();

    /**
     * Requests information about platform fonts which we used to render child TextNodes in the given
     * node.
     *
     * @param nodeId Id of the node to get background colors for.
     * @return Usage statistics for every employed platform font.
     */
    @Returns("fonts")
    List<PlatformFontUsage> getPlatformFontsForNode(@Param("nodeId") Integer nodeId);

    /**
     * Returns the current textual content for a stylesheet.
     *
     * @param styleSheetId styleSheet id
     * @return The stylesheet text.
     */
    @Returns("text")
    String getStyleSheetText(@Param("styleSheetId") String styleSheetId);

    /**
     * Find a rule with the given active property for the given node and set the new value for this property
     *
     * @param nodeId       The element id for which to set property.
     * @param propertyName property name
     * @param value        value
     */
    void setEffectivePropertyValueForNode(@Param("nodeId") int nodeId,
                                          @Param("propertyName") String propertyName, String value);

    /**
     * Modifies the keyframe rule key text.
     *
     * @param styleSheetId styleSheet id
     * @param range        range
     * @param keyText      key text
     * @return value
     */
    @Returns("keyText")
    Value setKeyframeKey(String styleSheetId, SourceRange range, String keyText);

    /**
     * Modifies the rule selector.
     *
     * @param styleSheetId styleSheet id
     * @param range        range
     * @param text         text
     * @return The resulting CSS media rule after modification.
     */
    @Returns("media")
    CSSMedia setMediaText(String styleSheetId, SourceRange range, String text);

    /**
     * Modifies the rule selector.
     *
     * @param styleSheetId styleSheet id
     * @param range        range
     * @param selector     selector
     * @return The resulting selector list after modification.
     */
    @Returns("selectorList")
    SelectorList setRuleSelector(String styleSheetId, SourceRange range, String selector);

    /**
     * Sets the new stylesheet text.
     *
     * @param styleSheetId styleSheet id
     * @param text         text
     * @return URL of source map associated with script (if any).
     */
    @Returns("sourceMapURL")
    String setStyleSheetText(String styleSheetId, String text);

    /**
     * Applies specified style edits one after another in the given order.
     *
     * @param edits StyleDeclarationEdit list
     * @return The resulting styles after modification.
     */
    @Returns("styles")
    List<CSSStyle> setStyleTexts(List<StyleDeclarationEdit> edits);

    /**
     * Enables the selector recording.
     */
    void startRuleUsageTracking();

    /**
     * Stop tracking rule usage and return the list of rules that were used since last call to takeCoverageDelta
     * (or since start of coverage instrumentation)
     *
     * @return ruleUsage
     */
    @Returns("ruleUsage")
    List<RuleUsage> stopRuleUsageTracking();

    /**
     * Obtain list of rules that became used since last call to this method
     * (or since start of coverage instrumentation)
     *
     * @return coverage
     */
    @Returns("coverage")
    List<RuleUsage> takeCoverageDelta();
}
