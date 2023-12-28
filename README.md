# Tip Calculator

## *Abdullah Arif*

**Tippy** computes the tip and total amount for a bill. The app uses the base amount and tip percentage to calculate the amount owed, and it also describes the quality of service based on the tip. Also, it splits the total bill for each person (if multiples are sharing the bill)

Time spent: **5** hours

## Functionality

The following functionalities are implemented:

* [x] User can enter in a bill amount (total amount to tip on)
* [x] User can enter a tip percentage (what % the user wants to tip).
* [x] The tip and total amount are updated immediately when any of the inputs changes.
* [x] The user sees a label or color update based on the tip amount.
* [x] Splitted total bill for N number of people
* [x] Ceiled up the total amount

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://im4.ezgif.com/tmp/ezgif-4-7c87608aa2.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

Used ceil() function for ceiling up the total amount. Divided the ceiled up total amount by Person to get total amount payable for each person

## License

    Copyright [2023] [Abdullah Arif]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.