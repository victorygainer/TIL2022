// '+' => 문자열 연결 연산자
console.log('my' + 'cat');
console.log("'5' + 2 = " + ('5' + 2)); // '52'
console.log('string literals: 1 + 2 = ${1 + 2}');
console.log(`string literals: 1 + 2 = ${1 + 2}`); // 그레이브 사용
console.log('===================================================');

// 산술 연산자
// '+'를 제외한 나머지 산술 연산자(-, *, /, %)는 문자와 숫자를 연산하면 숫자로 계산한다.
console.log("'5' - '2' = " + ('5' - '2')); // 3
console.log("'5' * '2' = " + ('5' * '2')); // 10
console.log("'5' / '2' = " + ('5' / '2')); // 2.5
console.log("Math.floor('5' / '2') = " + Math.floor('5' / '2')); // 2
console.log("('5' - 1) / 2 = " + ('5' - 1) / 2); // 2.5
console.log("'5' % 2 = " + '5' % 2); // 1
// console.log('5' ** 2); // 25, 거듭제곱, 에러가 표시되는데 실행이 되기는 한다.
console.log("Math.pow('5', 2) = " + Math.pow('5', 2)); // 25
console.log('===================================================');

// 증감 연산자
let counter = 2;
const preIncrement = ++counter;
console.log(`preIncrement: ${preIncrement}, counter: ${counter}`);
const postIncrement = counter++;
console.log(`postIncrement: ${postIncrement}, counter: ${counter}`);
console.log('===================================================');

// 대입 연산자
let x = 3;
let y = 6;
console.log(`x += y => x: ${x += y}`); // 9
console.log(`x -= y => x: ${x -= y}`); // 3
console.log(`x *= y => x: ${x *= y}`); // 18
console.log(`x /= y => x: ${x /= y}`); // 3
console.log(`x %= y => x: ${x %= y}`); // 3
console.log('===================================================');

// 관계 연산자
// 관계 연산자도 숫자와 문자를 비교해도 숫자로 비교된다.
console.log("10 < '6' = " + (10 < '6'));
console.log("10 <= 6 = " + (10 <= 6));
console.log("'10' > 6 = " + ('10' > 6));
console.log("10 >= 6 = " + (10 >= 6));
console.log("10 == 6 = " + (10 == 6));
console.log("10 != 6 = " + (10 != 6));

// 자바스크립트는 '===', '!==' 연산자가 있다.
// '==', '!='는 데이터 타입은 구분하지 않고 값만 비교한다.
// '===', '!=='는 데이터 타입과 값을 모두 비교한다.
console.log("10 == 10 = " + (10 == 10)); // true
console.log("'10' == 10 = " + ('10' == 10)); // true
console.log("'10' === 10 = " + ('10' === 10)); // false
console.log('===================================================');

// 논리 연산자
console.log("true && true = " + (true && true));
console.log("true && false = " + (true && false));
console.log("false && true = " + (false && true));
console.log("false && false = " + (false && false));

console.log("true || true = " + (true || true));
console.log("true || false = " + (true || false));
console.log("false || true = " + (false || true));
console.log("false || false = " + (false || false));

console.log("!false = " + !false);
// 자바스크립트는 0을 제외한 모든 숫자를 true로 0을 false로 취급한다.
console.log("!1 = " + !1);
console.log("!0 = " + !0);







