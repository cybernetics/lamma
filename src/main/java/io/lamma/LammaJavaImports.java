package io.lamma;

import static scala.collection.JavaConverters.collectionAsScalaIterableConverter;

import scala.collection.Iterable;
import scala.collection.JavaConverters;
import scala.collection.immutable.List;
import scala.collection.immutable.Set;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class contains interop alias to use Lamma with Java <br>
 *
 * It is suggested to always static import whole class when you are using Java<br>
 *  <br>
 *  import io.lamma.LammaJavaImports.*;
 */
public class LammaJavaImports {

    // =========== collections ================
    @SafeVarargs
    public static <E> Iterable<E> iterable(E ... elems) {
        return collectionAsScalaIterableConverter(new ArrayList<E>(Arrays.asList(elems))).asScala();
    }

    @SafeVarargs
    public static <E> List<E> list(E ... elems) {
        return iterable(elems).toList();
    }

    @SafeVarargs
    public static <E> Set<E> set(E ... elems) {
        return iterable(elems).toSet();
    }

    public static <E> List<E> scalaList(java.util.List<E> javaList) {
        return collectionAsScalaIterableConverter(javaList).asScala().toList();
    }

    public static <E> java.util.List<E> javaList(List<E> scalaList) {
        return JavaConverters.seqAsJavaListConverter(scalaList).asJava();
    }

    // ========= date & holidays ==========
    /**
     * helper method, alias of new Date(yyyy, mm, dd)
     *
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use constructor `new Date(yyyy, mm, dd)` instead
     */
    @Deprecated
    public static Date date(int yyyy, int mm, int dd) {
        return Dates.newDate(yyyy, mm, dd);
    }

    /**
     * helper method, takes an ISO representation to create a Date object. eg, date("2014-09-30")
     *
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `Dates.newDate(isoRepr)` instead
     */
    @Deprecated
    public static Date date(String isoRepr) {
        return Dates.newDate(isoRepr);
    }

    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `HolidayRules.NO_HOLIDAY` instead
     */
    @Deprecated
    public static HolidayRule noHoliday() {
        return HolidayRules.NO_HOLIDAY;
    }

    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `HolidayRules.WEEKENDS` instead
     */
    @Deprecated
    public static HolidayRule weekends() {
        return HolidayRules.WEEKENDS;
    }

    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `HolidayRules.newSimpleHolidayRule` instead
     */
    @Deprecated
    public static HolidayRule simpleHolidayRule(Date... holidays) {
        return HolidayRules.newSimpleHolidayRule(holidays);
    }

    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `HolidayRules.newSimpleHolidayRule` instead
     */
    @Deprecated
    public static HolidayRule simpleHolidayRule(Set<Date> holidays) {
        return new SimpleHolidayRule(holidays);
    }

    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `HolidayRules.newCompositeHolidayRules` instead
     */
    @Deprecated
    public static HolidayRule compositeHolidayRules(HolidayRule... rules) {
        return CompositeHolidayRule$.MODULE$.apply(iterable(rules).<HolidayRule>toSeq());
    }

    // ========= shifters =========
    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `Shifters.NO_SHIFT` instead
     */
    @Deprecated
    public static Shifter noShift() {
        return Shifters.NO_SHIFT;
    }

    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `Shifters.newCalendarDaysShifter` instead
     */
    @Deprecated
    public static Shifter shiftCalendarDays(int days) {
        return Shifters.newCalendarDaysShifter(days);
    }

    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `Shifters.newWorkingDaysShifter` instead
     */
    @Deprecated
    public static Shifter shiftWorkingDays(int days) {
        return Shifters.newWorkingDaysShifter(days);
    }

    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `Shifters.newWorkingDaysShifter` instead
     */
    @Deprecated
    public static Shifter shiftWorkingDays(int days, HolidayRule rule) {
        return Shifters.newWorkingDaysShifter(days, rule);
    }

    // ========= selectors =========
    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `Selectors.SAME_DAY_SELECTOR` instead
     */
    @Deprecated
    public static Selector sameDay() {
        return Selectors.SAME_DAY_SELECTOR;
    }

    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `Selectors.newForwardSelector` instead
     */
    @Deprecated
    public static Selector forward() {
        return Selectors.newForwardSelector();
    }

    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `Selectors.newForwardSelector` instead
     */
    @Deprecated
    public static Selector forward(HolidayRule rule) {
        return Selectors.newForwardSelector(rule);
    }

    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `Selectors.newBackwardSelector` instead
     */
    @Deprecated
    public static Selector backward() {
        return Selectors.newBackwardSelector();
    }

    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `Selectors.newBackwardSelector` instead
     */
    @Deprecated
    public static Selector backward(HolidayRule rule) {
        return Selectors.newBackwardSelector(rule);
    }

    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `Selectors.newModifiedFollowingSelector` instead
     */
    @Deprecated
    public static Selector modifiedFollowing() {
        return Selectors.newModifiedFollowingSelector();
    }

    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `Selectors.newModifiedFollowingSelector` instead
     */
    @Deprecated
    public static Selector modifiedFollowing(HolidayRule rule) {
        return Selectors.newModifiedFollowingSelector(rule);
    }

    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `Selectors.newModifiedPrecedingSelector` instead
     */
    @Deprecated
    public static Selector modifiedPreceding() {
        return Selectors.newModifiedPrecedingSelector();
    }

    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `Selectors.newModifiedPrecedingSelector` instead
     */
    @Deprecated
    public static Selector modifiedPreceding(HolidayRule rule) {
        return Selectors.newModifiedPrecedingSelector(rule);
    }

    // ========== day of month ==============
    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `DayOfMonths.firstDayOfMonth` instead
     */
    @Deprecated
    public static DayOfMonth firstDayOfMonth() {
        return DayOfMonths.firstDayOfMonth();
    }

    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `DayOfMonths.nthDayOfMonth` instead
     */
    @Deprecated
    public static DayOfMonth nthDayOfMonth(int n) {
        return DayOfMonths.nthDayOfMonth(n);
    }

    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `DayOfMonths.lastDayOfMonth` instead
     */
    @Deprecated
    public static DayOfMonth lastDayOfMonth() {
        return DayOfMonths.lastDayOfMonth();
    }

    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `DayOfMonths.firstWeekdayOfMonth` instead
     */
    @Deprecated
    public static DayOfMonth firstWeekdayOfMonth(DayOfWeek dow) {
        return DayOfMonths.firstWeekdayOfMonth(dow);
    }

    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `DayOfMonths.nthWeekdayOfMonth` instead
     */
    @Deprecated
    public static DayOfMonth nthWeekdayOfMonth(int n, DayOfWeek dow) {
        return DayOfMonths.nthWeekdayOfMonth(n, dow);
    }

    /**
     * @deprecated (since 2.2.0 will be removed in 2.3.0) use `DayOfMonths.lastWeekdayOfMonth` instead
     */
    @Deprecated
    public static DayOfMonth lastWeekdayOfMonth(DayOfWeek dow) {
        return DayOfMonths.lastWeekdayOfMonth(dow);
    }

    // ========== day of year ==============
    public static DayOfYear firstDayOfYear() {
        return DayOfYears.firstDayOfYear();
    }

    public static DayOfYear secondDayOfYear() {
        return DayOfYears.secondDayOfYear();
    }

    public static DayOfYear nthDayOfYear(int n) {
        return DayOfYears.nthDayOfYear(n);
    }

    public static DayOfYear lastDayOfYear() {
        return DayOfYears.lastDayOfYear();
    }

    public static DayOfYear firstWeekDayOfYear(DayOfWeek dow) {
        return DayOfYears.firstWeekDayOfYear(dow);
    }

    public static DayOfYear nthWeekdayOfYear(int n, DayOfWeek dow) {
        return DayOfYears.nthWeekdayOfYear(n, dow);
    }

    public static DayOfYear lastWeekdayOfYear(DayOfWeek dow) {
        return DayOfYears.lastWeekdayOfYear(dow);
    }

    public static DayOfYear firstMonthOfYear(DayOfMonth dom) {
        return DayOfYears.firstMonthOfYear(dom);
    }

    public static DayOfYear nthMonthOfYear(Month m, DayOfMonth dom) {
        return DayOfYears.nthMonthOfYear(m, dom);
    }

    public static DayOfYear lastMonthOfYear(DayOfMonth dom) {
        return DayOfYears.lastMonthOfYear(dom);
    }

    // ========== recurrence pattern ==============
    public static Daily everyDay() {
        return new Daily(1);
    }

    public static Daily everyOtherDay() {
        return new Daily(2);
    }

    public static Daily days(int days) {
        return new Daily(days);
    }

    public static Daily daysBackward(int days) {
        return new Daily(- days);
    }

    public static Weekly everyWeek() {
        return Weekly$.MODULE$.apply(1, Weekly$.MODULE$.apply$default$2());
    }

    public static Weekly everyOtherWeek() {
        return Weekly$.MODULE$.apply(2, Weekly$.MODULE$.apply$default$2());
    }

    public static Weekly weeks(int weeks) {
        return Weekly$.MODULE$.apply(weeks, Weekly$.MODULE$.apply$default$2());
    }

    public static Weekly weeks(DayOfWeek dow) {
        return Weekly$.MODULE$.apply(1, dow);
    }

    public static Weekly weeks(int weeks, DayOfWeek dow) {
        return Weekly$.MODULE$.apply(weeks, dow);
    }

    public static Weekly weeksBackward(int weeks) {
        return Weekly$.MODULE$.apply(- weeks, Weekly$.MODULE$.apply$default$2());
    }

    public static Weekly weeksBackward(DayOfWeek dow) {
        return Weekly$.MODULE$.apply(-1, dow);
    }

    public static Weekly weeksBackward(int weeks, DayOfWeek dow) {
        return Weekly$.MODULE$.apply(- weeks, dow);
    }

    public static Monthly everyMonth() {
        return Monthly$.MODULE$.apply(1, Monthly$.MODULE$.apply$default$2());
    }

    public static Monthly everyOtherMonth() {
        return Monthly$.MODULE$.apply(2, Monthly$.MODULE$.apply$default$2());
    }

    public static Monthly months(int n) {
        return Monthly$.MODULE$.apply(n, Monthly$.MODULE$.apply$default$2());
    }

    public static Monthly months(DayOfMonth dom) {
        return Monthly$.MODULE$.apply(1, dom);
    }

    public static Monthly months(int n, DayOfMonth dom) {
        return Monthly$.MODULE$.apply(n, dom);
    }

    public static Monthly monthsBackward(int n) {
        return Monthly$.MODULE$.apply(-n, Monthly$.MODULE$.apply$default$2());
    }

    public static Monthly monthsBackward(DayOfMonth dom) {
        return Monthly$.MODULE$.apply(-1, dom);
    }

    public static Monthly monthsBackward(int n, DayOfMonth dom) {
        return Monthly$.MODULE$.apply(-n, dom);
    }

    public static Yearly everyYear() {
        return Yearly$.MODULE$.apply(1, Yearly$.MODULE$.apply$default$2());
    }

    public static Yearly everyOtherYear() {
        return Yearly$.MODULE$.apply(2, Yearly$.MODULE$.apply$default$2());
    }

    public static Yearly years(int n) {
        return Yearly$.MODULE$.apply(n, Yearly$.MODULE$.apply$default$2());
    }

    public static Yearly years(DayOfYear doy) {
        return Yearly$.MODULE$.apply(1, doy);
    }

    public static Yearly years(int n, DayOfYear doy) {
        return Yearly$.MODULE$.apply(n, doy);
    }

    public static Yearly yearsBackward(int n) {
        return Yearly$.MODULE$.apply(-n, Yearly$.MODULE$.apply$default$2());
    }

    public static Yearly yearsBackward(DayOfYear doy) {
        return Yearly$.MODULE$.apply(-1, doy);
    }

    public static Yearly yearsBackward(int n, DayOfYear doy) {
        return Yearly$.MODULE$.apply(-n, doy);
    }

    // ============== period builder / stub rule ===============
    public static StubRulePeriodBuilder stubRulePeriodBuilder() {
        return StubRulePeriodBuilder$.MODULE$.apply(StubRulePeriodBuilder$.MODULE$.apply$default$1(), StubRulePeriodBuilder$.MODULE$.apply$default$2());
    }

    public static StubRulePeriodBuilder stubRulePeriodBuilder(StubRulePeriodBuilder.StartRule start) {
        return StubRulePeriodBuilder$.MODULE$.apply(start, StubRulePeriodBuilder$.MODULE$.apply$default$2());
    }

    public static StubRulePeriodBuilder stubRulePeriodBuilder(StubRulePeriodBuilder.EndRule end) {
        return StubRulePeriodBuilder$.MODULE$.apply(StubRulePeriodBuilder$.MODULE$.apply$default$1(), end);
    }

    public static StubRulePeriodBuilder stubRulePeriodBuilder(StubRulePeriodBuilder.StartRule start, StubRulePeriodBuilder.EndRule end) {
        return StubRulePeriodBuilder$.MODULE$.apply(start, end);
    }

    public static StubRulePeriodBuilder.StartRule noStartRule() {
        return StubRulePeriodBuilder$.MODULE$.NoStartRule();
    }

    public static StubRulePeriodBuilder.StartRule longStart() {
        return new StubRulePeriodBuilder.LongStart(StubRulePeriodBuilder.LongStart$.MODULE$.apply$default$1());
    }

    public static StubRulePeriodBuilder.StartRule longStart(int n) {
        return StubRulePeriodBuilder.LongStart$.MODULE$.apply(n);
    }

    public static StubRulePeriodBuilder.StartRule shortStart() {
        return new StubRulePeriodBuilder.ShortStart(StubRulePeriodBuilder.ShortStart$.MODULE$.apply$default$1());
    }

    public static StubRulePeriodBuilder.StartRule shortStart(int n) {
        return StubRulePeriodBuilder.ShortStart$.MODULE$.apply(n);
    }

    public static StubRulePeriodBuilder.EndRule noEndRule() {
        return StubRulePeriodBuilder$.MODULE$.NoEndRule();
    }

    public static StubRulePeriodBuilder.EndRule longEnd() {
        return new StubRulePeriodBuilder.LongEnd(StubRulePeriodBuilder.LongEnd$.MODULE$.apply$default$1());
    }

    public static StubRulePeriodBuilder.EndRule longEnd(int n) {
        return StubRulePeriodBuilder.LongEnd$.MODULE$.apply(n);
    }

    public static StubRulePeriodBuilder.EndRule shortEnd() {
        return new StubRulePeriodBuilder.ShortEnd(StubRulePeriodBuilder.ShortEnd$.MODULE$.apply$default$1());
    }

    public static StubRulePeriodBuilder.EndRule shortEnd(int n) {
        return StubRulePeriodBuilder.ShortEnd$.MODULE$.apply(n);
    }

    // ================== DateDef and Anchor================
    public static Anchor periodEnd() {
        return Anchor.PeriodEnd$.MODULE$;
    }

    public static Anchor periodStart() {
        return Anchor.PeriodStart$.MODULE$;
    }

    public static Anchor otherDate(String name) {
        return new Anchor.OtherDate(name);
    }

    public static DateDef dateDef(String name) {
        return new DateDef(name, DateDef$.MODULE$.apply$default$2(), DateDef$.MODULE$.apply$default$3(), DateDef$.MODULE$.apply$default$4());
    }

    public static DateDef dateDef(String name, Anchor relativeTo) {
        return new DateDef(name, relativeTo, DateDef$.MODULE$.apply$default$3(), DateDef$.MODULE$.apply$default$4());
    }

    public static DateDef dateDef(String name, Shifter shifter) {
        return new DateDef(name, DateDef$.MODULE$.apply$default$2(), shifter, DateDef$.MODULE$.apply$default$4());
    }

    public static DateDef dateDef(String name, Selector selector) {
        return new DateDef(name, DateDef$.MODULE$.apply$default$2(), DateDef$.MODULE$.apply$default$3(), selector);
    }

    public static DateDef dateDef(String name, Anchor relativeTo, Shifter shifter) {
        return new DateDef(name, relativeTo, shifter, DateDef$.MODULE$.apply$default$4());
    }

    public static DateDef dateDef(String name, Anchor relativeTo, Selector selector) {
        return new DateDef(name, relativeTo, DateDef$.MODULE$.apply$default$3(), selector);
    }

    public static DateDef dateDef(String name, Shifter shifter, Selector selector) {
        return new DateDef(name, DateDef$.MODULE$.apply$default$2(), shifter, selector);
    }

    public static DateDef dateDef(String name, Anchor relativeTo, Shifter shifter, Selector selector) {
        return new DateDef(name, relativeTo, shifter, selector);
    }
}
