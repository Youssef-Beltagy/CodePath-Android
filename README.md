# Project 1 - CodePathPrework

**CodePathPrework** is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: **Youssef Beltagy**

Time spent: **8** hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **view a list of todo items**
* [x] User can **successfully add and remove items** from the todo list
* [x] User's **list of items persisted** upon modification and and retrieved properly on app restart

The following **optional** features are implemented:

* [x] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list

The following **additional** features are implemented:

* [x] Using the newest `registerForActivityResult` instead of the deprecated `startActivityForResult` in the guide
* [x] Edit and delete buttons instead of short and long clicks (more intuitive) 
* [x] Red done button, Green add button, Blue edit button
* [x] Small done and edit buttons
* [ ] TODO: SQlite DB instead of a text file
* [ ] TODO: add task due date
* [ ] TODO: order tasks by most recent due date

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://raw.githubusercontent.com/Youssef-Beltagy/CodePath-Android/main/demo.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

The video tutorial made everything easy. But when I was adding the editing functionality, I realized `startActivityForResult` is deprecated and the guide is outdated.

It was challenging to find and learn how to use the new method. That probably took more time than the rest of the whole project.

## License

    Copyright [yyyy] [name of copyright owner]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.